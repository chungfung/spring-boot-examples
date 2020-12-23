package com.chungfung.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @author 丰涌
 * @version 1.0
 * @description TODO
 * @date 2020/12/23 11:11
 **/
@Data
@ToString
public class MessageBody {

    /** 消息内容 */
    private String content;

    /** 广播转发的目标地址（告知 STOMP 代理转发到哪个地方） */
    private String destination;
}