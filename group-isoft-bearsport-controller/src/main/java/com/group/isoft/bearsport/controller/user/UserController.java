package com.group.isoft.bearsport.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.group.isoft.bearsport.clientmodel.user.OauthInfo;
import com.group.isoft.bearsport.clientmodel.user.UserReqModel;
import com.group.isoft.bearsport.clientmodel.user.UserRespModel;
import com.group.isoft.bearsport.model.user.User;
import com.group.isoft.bearsport.user.IUserService;
import com.group.isoft.bearsport.util.Constant;
import com.group.isoft.bearsport.util.ErrorCode;
import com.group.isoft.bearsport.util.OperationCode;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger sysLogger = Logger.getLogger("customer");

	@Resource
	IUserService userService;

	@RequestMapping(value = "/Login", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object Login(final HttpServletRequest request, final HttpServletResponse response, HttpSession session,
			@RequestBody UserReqModel userRequest) {

		UserRespModel userRespModel = new UserRespModel();

		try {
			OauthInfo oauthInfo = null;

			oauthInfo = getOauthInfo(userRequest.getCode());

			if (null != oauthInfo) {
				Map<String, String> params = new HashMap<String, String>();
				params.put("openId", oauthInfo.getOpenId());
				userRespModel.setParams(params);

				userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("currentUserId", userRespModel.getParams().get("openId"));
		return userRespModel;
	}

	@RequestMapping(value = "/userMaintain", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object userMaintain(final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody UserReqModel userRequest) throws Exception {
		UserRespModel userRespModel = new UserRespModel();

		if (userRequest.getOperationCode().equals(OperationCode.USER_CREATION)) {
			userRespModel = addUser(userRequest);
		} else if (userRequest.getOperationCode().equals(OperationCode.USER_FETCH)) {
			userRespModel = fetchUserList(userRequest);
		} else if (userRequest.getOperationCode().equals(OperationCode.USER_FETCH_OPEN_ID)) {
			userRespModel = fetchUserByOpenId(userRequest);
		} else if (userRequest.getOperationCode().equals(OperationCode.USER_UPDATE)) {
			userRespModel = updateUserInfo(userRequest);
		}
		return userRespModel;
	}

	private OauthInfo getOauthInfo(String code) throws Exception {
		 //构造HttpClient的实例
		  HttpClient httpClient = new DefaultHttpClient();
		  OauthInfo oAuthInfo = new OauthInfo();

		  List<NameValuePair> params = new ArrayList<NameValuePair>();
		  params.add(new BasicNameValuePair("appid", Constant.APP_ID));
		  params.add(new BasicNameValuePair("secret", Constant.SECRET));
		  params.add(new BasicNameValuePair("grant_type", Constant.GRANT_TYPE));
		  params.add(new BasicNameValuePair("js_code", code));

		  String urlParams = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));

		  //创建GET方法的实例
		  HttpGet httpGet = new HttpGet(Constant.OPEN_ID_URL + "?" + urlParams);

		  HttpResponse response = httpClient.execute(httpGet);
		  HttpEntity entity = response.getEntity();
		  String responseStr =  EntityUtils.toString(entity, "UTF-8");

		  JSONObject jsonObject = JSONObject.fromObject(responseStr);

		  if (null != jsonObject) {

	          try {
	                oAuthInfo.setAccessToken(jsonObject.getString("session_key"));
	                oAuthInfo.setExpireIn(jsonObject.getInt("expires_in"));
	                oAuthInfo.setOpenId(jsonObject.getString("openid"));
	          } catch (JSONException e) {
	                oAuthInfo = null;
	                // 获取token失败
	                sysLogger.error("网页授权获取openId失败 errcode:{} errmsg:{}" + jsonObject
	                        .getString("errcode") + jsonObject.getString("errmsg"));
	          }
	        }
	        return oAuthInfo;
	}

	private UserRespModel addUser(@RequestBody UserReqModel userRequest) throws Exception {
		return userService.addUser(userRequest);
	}

	private UserRespModel fetchUserList(@RequestBody UserReqModel userRequest) throws Exception {
		return userService.fetchUserList(userRequest);
	}

	private UserRespModel fetchUserByOpenId(@RequestBody UserReqModel userRequest) throws Exception {
		return userService.fetchUserByOpenId(userRequest);
	}

	private UserRespModel updateUserInfo(@RequestBody UserReqModel userRequest) throws Exception {
		return userService.updateUser(userRequest);
	}

}
