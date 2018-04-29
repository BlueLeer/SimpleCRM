package com.lee.crm.action;

import com.lee.crm.utils.VerifyCode;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
public class GlobalAction extends BaseAction {
    public String verifycode() {
        try {
            VerifyCode verifyCode = new VerifyCode();
            BufferedImage image = verifyCode.getImage();
            String verifyCodeText = verifyCode.getText();
            // 将验证码文本保存到session域中
            getSession().put("session_verifycode", verifyCodeText);
            // 将验证码图片保存到响应流中
            VerifyCode.output(image, ServletActionContext.getResponse().getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return NONE;
    }
}
