package com.b304.bobs.api.service.Recipe;

import com.b304.bobs.api.response.PageRes;
import com.b304.bobs.api.response.Recipe.RecipeRes;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService {
     RecipeRes findOneById(Long community_id) throws Exception;
     PageRes findAll() throws Exception;
     PageRes findByUserLike(Long user_id) throws Exception;
     PageRes findIngredientsById(Long recipe_id) throws Exception;
     void recipeLike(Long userId, Long recipe_like_id) throws Exception;
}