package com.b304.bobs.api.service.Allergy;

import com.b304.bobs.api.request.Allergy.AllergyReq;
import com.b304.bobs.api.response.Allergy.AllergyRes;
import com.b304.bobs.api.response.PageRes;
import com.b304.bobs.db.entity.Allergy;
import com.b304.bobs.db.repository.AllergyRepository;
import com.b304.bobs.db.repository.IngredientRepository;
import com.b304.bobs.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AllergyServiceImpl implements AllergyService {
    private final AllergyRepository allergyRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public boolean createAllergy(AllergyReq allergyReq) throws Exception {
        List<Map<String,String>> lst = allergyReq.getAllergy_list();

        try{
            if(userRepository.findById(allergyReq.getUser_id()).isEmpty()){
                return false;
            }else{
                for(Map<String,String> map : lst){
                    //재료 id
                    Long allergy_id = Long.valueOf(map.get("ingredient_id"));
                    boolean is_deleted = Boolean.parseBoolean(map.get("is_deleted"));

                    Allergy allergy = allergyRepository.findByIngredientId(allergy_id).orElseGet(Allergy::new);

                    allergy.setUser(userRepository.findById(allergyReq.getUser_id()).get());
                    allergy.set_deleted(is_deleted);
                    allergy.setIngredient(ingredientRepository.findById(allergy_id).get());
                    allergy.setAllergy_name(allergy.getIngredient().getIngredient_name());

                    allergyRepository.save(allergy);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }


    @Override
    @Transactional(readOnly = true)
    public PageRes findById(Long user_id) throws Exception{
        PageRes pageRes = new PageRes();

        try {
            List<Allergy> allergies = allergyRepository.findByUserId(user_id);
            if(allergies.isEmpty()) return pageRes;
            pageRes
                    .setContents(allergies.stream()
                            .map(AllergyRes::new)
                            .collect(Collectors.toList())
                    );
        }catch (Exception e){
            e.printStackTrace();
        }
        return pageRes;
    }
}