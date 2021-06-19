package com.purvesh.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostDTO {

    @Length(max = 450)
    @Valid
    String title;
    @Length(max = 5000)
    @Valid
    String body;
    @Valid
    Integer post_id;
}
