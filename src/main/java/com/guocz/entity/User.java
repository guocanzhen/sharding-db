package com.guocz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author springBoot-Learning
 * @since 2022-07-25
 */
@TableName("t_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("UserName")
    private String userName;

    @TableField("UserId")
    private String userId;

    @TableField("ProductDescription")
    private String productDescription;

    @TableField("UserMemo")
    private String userMemo;

}
