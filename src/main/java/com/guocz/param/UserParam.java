package com.guocz.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author guocz
 * @date 2022/7/25 14:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserParam extends BaseParam{

    private Long id;

    private String userName;

}
