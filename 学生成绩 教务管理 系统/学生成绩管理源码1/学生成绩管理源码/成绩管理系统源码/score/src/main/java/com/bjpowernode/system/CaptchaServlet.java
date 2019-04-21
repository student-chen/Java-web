package com.bjpowernode.system;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bjpowernode.common.util.CaptchaUtil;
import com.bjpowernode.common.util.SystemConstant;

/**
 * 验证码servlet
 * @author Administrator
 *
 */
public class CaptchaServlet extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(CaptchaServlet.class);

	private static final long serialVersionUID = -124247581620199710L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("image/jpeg");
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expire", 0);
		try {

			HttpSession session = req.getSession();
			CaptchaUtil tool = new CaptchaUtil();
			StringBuffer code = new StringBuffer();
			BufferedImage image = tool.genRandomCodeImage(code);
			session.removeAttribute(SystemConstant.KEY_CAPTCHA);
			session.setAttribute(SystemConstant.KEY_CAPTCHA, code.toString());
			LOGGER.debug("验证码生成");
			ImageIO.write(image, "JPEG", resp.getOutputStream());
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}