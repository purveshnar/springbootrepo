package com.purvesh.springboot.util;

import com.purvesh.springboot.model.Posts;

import java.util.HashMap;
import java.util.Map;

public class PostMapper {
    public Map postDetailsToMap(Posts post) {
        Map map = new HashMap();
        map.put("post_id", post.getPostId().toString());
        map.put("title", post.getPostTitle());
        map.put("body", post.getPostBody());
        map.put("created_on", post.getCreatedOn());
        //map.put("created_by", post.getPublishedBy().getUserName());
        map.put("last_updated", post.getUpdatedOn());
        return map;
    }
}
