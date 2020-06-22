package com.zzp.phone.stage.util;


import com.zzp.phone.stage.vo.ResultVo;
/**
 * <标题>
 * <p>
 *  //TODO
 *  ResultVoUtil.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 23:09
 * @see  ResultVoUtil
 **/
public class ResultVoUtil {
    public static <T>ResultVo<T> success(T data){
        var resultVo = new ResultVo<T>();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo<?> error(String error){
        var resultVo = new ResultVo<>();
        resultVo.setCode(1);
        resultVo.setMsg(error);
        resultVo.setData(null);
        return resultVo;
    }
}
