package com.purvesh.springboot.util;

import com.purvesh.springboot.model.Posts;
import com.purvesh.springboot.model.RegisterUserDTO;
import com.purvesh.springboot.model.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PostMapper {
    public Map postDetailsToMap(Posts post) {
        Map map = new HashMap();
        map.put("post_id", post.getPostId().toString());
        map.put("title", post.getPostTitle());
        map.put("body", post.getPostBody());
        map.put("created_on",post.getCreatedOn());
        map.put("created_by", post.getPublishedBy().getUserName());
        map.put("last_updated", post.getUpdatedOn());
        return map;
    }
}
