package com.laoshe.controller;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.laoshe.base.LaosheResponse;
import com.laoshe.constant.CodeSet;
import com.laoshe.mapper.UserInfoMapper;
import com.laoshe.utils.FileUtil;
import com.laoshe.utils.SendMsgUtil;

@Controller
@RequestMapping(value = "/operation")
public class UtilsController {
    static final int pageSize=10;
    
    @Autowired
	private UserInfoMapper userMapper;
    
    @Value("${menu.img.uploadUrl}")
	private String uploadUrl;
    
    @Value("${menu.img.ip}")
	private String ip;
    
    @Autowired
    private SendMsgUtil sendMsgUtil;
    @ResponseBody
    @RequestMapping(value = "/sendMsg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse addUser(@RequestParam String mobile){
    	Boolean res = sendMsgUtil.SendMsg(mobile);
    	if (res) {
    		return LaosheResponse.success("发送成功");
		}else{
			return LaosheResponse.error(CodeSet.SYSTEM_ERR_CODE,"发送失败，请重试");
		}
    }
    @ResponseBody
    @RequestMapping(value = "/upload", method=RequestMethod.POST)
	public LaosheResponse uploadImg(@RequestParam("file") MultipartFile file) throws Exception {
    	String uiid = UUID.randomUUID().toString();
    	LaosheResponse response = new LaosheResponse();
    	if (file != null) {
    		String oldName = file.getOriginalFilename();
			String imgType = oldName.substring(oldName.lastIndexOf("."), oldName.length());
			String name = uiid+imgType; // 图片名
			//上传文件
			FileUtil.uploadFile(file.getBytes(), uploadUrl, name);
			response.setData("http://"+ip+"/"+name);
			response.setRetCode(CodeSet.SUCCESS_CODE);
			response.setSuccess(true);
			response.setRetMsg("上传成功");
		}
		return response;
	}

}
