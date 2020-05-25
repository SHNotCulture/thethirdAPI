package com.api.handle;
import com.api.entity.ActionRsp;
import com.api.exception.ActionRspException;
import com.api.util.ActionRspUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author lishuhan
 * @Description:系统统一异常捕捉类
 * @Date Create in 17:272018-5-9
 * @Modified By:
 */
@ControllerAdvice
public class ExceptionHandle  {
    private  static final Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ActionRsp handle(Exception e){
        if(e instanceof ActionRspException){
            ActionRspException actionRspException=(ActionRspException)e;
            return ActionRspUtil.Error(actionRspException.getCode(),actionRspException.getMessage());
        }
        else
        {
            logger.info("【系统错误】"+e.toString());
            return ActionRspUtil.Error(-1,"UNKONW_ERROR");
        }

    }
}
