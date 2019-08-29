package com.sleepy.food.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sleepy
 * @since 2019-08-29
 */
@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
@Data //get set 方法
@Accessors(chain = true) //链式调用
@ToString
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value="id" , type = IdType.UUID)
    private String id;

    private String username;

    private String password;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
