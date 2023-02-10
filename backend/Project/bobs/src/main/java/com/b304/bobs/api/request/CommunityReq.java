package com.b304.bobs.api.request;

import com.b304.bobs.db.entity.Community;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter @Setter
@Data
public class CommunityReq {
    private Long user_id;
    private String user_name;
    private Long community_id;
    private String community_title;
    private String community_content;
    private int community_hit;
    private MultipartFile community_img;

    public CommunityReq() {
    }

    public CommunityReq(Long user_id, String user_name, Long community_id, String community_title, String community_content, int community_hit, LocalDateTime community_created, boolean community_deleted, MultipartFile community_img) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.community_id = community_id;
        this.community_title = community_title;
        this.community_content = community_content;
        this.community_hit = community_hit;
        this.community_img = community_img;
    }

}