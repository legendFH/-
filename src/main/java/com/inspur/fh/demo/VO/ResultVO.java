package com.inspur.fh.demo.VO;

/**
 * http请求返回的最外层对象
 * @author fh
 * @date 2019/4/22  15:48
 */
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;
}
