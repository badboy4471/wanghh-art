package com.whh.art.utils;

public enum ArtErrorCode {
	OK {
		@Override
		public int getCode() {
			return 200;
		}

		@Override
		public String getMessage() {
			return "处理成功！";
		}
	},
	
	SYSTEM_ERROR {
		@Override
		public int getCode() {
			return 10001;
		}

		@Override
		public String getMessage() {
			return "系统错误！";
		}
	},
	DUPLICATE {
		@Override
		public int getCode() {
			return 10002;
		}

		@Override
		public String getMessage() {
			return "编号重复！";
		}
	},
	PARAMETER_ERROR {
		@Override
		public int getCode() {
			return 10003;
		}

		@Override
		public String getMessage() {
			return "参数错误！";
		}
	},
	RIGHT_ERROR {
		@Override
		public int getCode() {
			return 10004;
		}

		@Override
		public String getMessage() {
			return "权限错误！";
		}
	},
	BLACKUSER {
		@Override
		public int getCode() {
			return 10005;
		}

		@Override
		public String getMessage() {
			return "黑名单！";
		}
	},
	USER_TYPE_ERROE {
		@Override
		public int getCode() {
			return 10006;
		}

		@Override
		public String getMessage() {
			return "账号类型与平台不符！";
		}
	},
	NO_LOGIN {
		@Override
		public int getCode() {
			return 10101;
		}

		@Override
		public String getMessage() {
			return "未登录！";
		}
	},
	SENSITIVE {
		@Override
		public int getCode() {
			return 10102;
		}

		@Override
		public String getMessage() {
			return "包含敏感词！";
		}
	},
	FUNNY_USER_LOGIN_ERROR {
		@Override
		public int getCode() {
			return 10007;
		}

		@Override
		public String getMessage() {
			return "请使用QQ或者新浪微博登录！";
		}
	},
	EMAIL_USED {
		@Override
		public int getCode() {
			return 20101;
		}

		@Override
		public String getMessage() {
			return "邮箱已经被注册！";
		}
	},
	EMAIL_NOT_EXIST {
		@Override
		public int getCode() {
			return 20102;
		}

		@Override
		public String getMessage() {
			return "手机号码或者邮箱不存在！";
		}
	},
	EMAIL_ERROR {
		@Override
		public int getCode() {
			return 20103;
		}

		@Override
		public String getMessage() {
			return "邮箱格式错误！";
		}
	},
	MOBILE_USED {
		@Override
		public int getCode() {
			return 20104;
		}

		@Override
		public String getMessage() {
			return "该手机号已注册，可以直接使用手机号登录";
		}
	},
	MOBILE_CODE_ERROR {
		@Override
		public int getCode() {
			return 20105;
		}

		@Override
		public String getMessage() {
			return "验证码错误！";
		}
	},
	MOBILE_ERROR {
		@Override
		public int getCode() {
			return 20106;
		}

		@Override
		public String getMessage() {
			return "手机号码格式错误！";
		}
	},
	MOBILE_CODE_SEND_ERROR {
		@Override
		public int getCode() {
			return 20107;
		}

		@Override
		public String getMessage() {
			return "验证码发送失败！";
		}
	},
	MOBILE_CODE_MAX {
		@Override
		public int getCode() {
			return 20108;
		}

		@Override
		public String getMessage() {
			return "验证码发送次数超限额！";
		}
	},
	MOBILE_EMPTY {
		@Override
		public int getCode() {
			return 20109;
		}

		@Override
		public String getMessage() {
			return "手机号码为空，需要绑定手机号码！";
		}
	},
	NOT_BLANK_MOBILE {
		@Override
		public int getCode() {
			return 20110;
		}

		@Override
		public String getMessage() {
			return "手机号码，不为白名单";
		}
	},
	PASSWARD_ERROR {
		@Override
		public int getCode() {
			return 20201;
		}

		@Override
		public String getMessage() {
			return "密码格式错误！";
		}
	},
	NICKNAME_ERROR {
		@Override
		public int getCode() {
			return 20301;
		}

		@Override
		public String getMessage() {
			return "昵称格式错误！";
		}
	},
	LOGIN_ERROR {
		@Override
		public int getCode() {
			return 20401;
		}

		@Override
		public String getMessage() {
			return "用户名密码不正确！";
		}
	},
	USER_NOT_EXIST {
		@Override
		public int getCode() {
			return 20402;
		}

		@Override
		public String getMessage() {
			return "该用户不存在！";
		}
	},
	ACCOUNT_EXIST {
		@Override
		public int getCode() {
			return 20403;
		}

		@Override
		public String getMessage() {
			return "该账号已经被绑定了！";
		}
	},
	BIND_SAME {
		@Override
		public int getCode() {
			return 20404;
		}

		@Override
		public String getMessage() {
			return "该平台已经绑定了其他帐号，请用原来帐号进行绑定！";
		}
	},
	USER_FORBID {
		@Override
		public int getCode() {
			return 20405;
		}

		@Override
		public String getMessage() {
			return "该用户已经被禁言，请联系管理员！";
		}
	},
	USER_SHIELD {
		@Override
		public int getCode() {
			return 20406;
		}

		@Override
		public String getMessage() {
			return "该用户已经被屏蔽，请联系管理员！";
		}
	},
	USER_ONLYFRIEND {
		@Override
		public int getCode() {
			return 20407;
		}

		@Override
		public String getMessage() {
			return "用户设置仅好友可查看！";
		}
	},
	USER_FRIENDONLY {
		@Override
		public int getCode() {
			return 20411;
		}

		@Override
		public String getMessage() {
			return "用户设置只看好友的视频！";
		}
	},

	BIND_EXPIRED {
		@Override
		public int getCode() {
			return 20408;
		}

		@Override
		public String getMessage() {
			return "该平台绑定已经过期，请重新绑定！";
		}
	},
	OPEN_ACCOUNT_ONLY_ONE {
		@Override
		public int getCode() {
			return 20409;
		}

		@Override
		public String getMessage() {
			return "只绑定了一个平台，不能再解除绑定了。";
		}
	},
	USER_ROLEID_ERROR {
		@Override
		public int getCode() {
			return 20410;
		}

		@Override
		public String getMessage() {
			return "用户类型有误！";
		}
	},
	CONTENT_DESC_ERROR {
		@Override
		public int getCode() {
			return 20501;
		}

		@Override
		public String getMessage() {
			return "内容描述格式有误！";
		}
	},
	USER_ONTLOOKOTHER {
		@Override
		public int getCode() {
			return 20502;
		}

		@Override
		public String getMessage() {
			return "用户设置不看别人视频！";
		}
	},
	USER_ONTOTHERLOOK {
		@Override
		public int getCode() {
			return 20503;
		}

		@Override
		public String getMessage() {
			return "用户设置不让别人看我的视频！";
		}
	},
	USER_FRIEND {
		@Override
		public int getCode() {
			return 20504;
		}

		@Override
		public String getMessage() {
			return "已经是好友啦！";
		}
	},
	CANNOTE_FOLLOW {
		@Override
		public int getCode() {
			return 20505;
		}

		@Override
		public String getMessage() {
			return "不能被关注！";
		}
	},
	GROUP_EXIST {
		@Override
		public int getCode() {
			return 20601;
		}

		@Override
		public String getMessage() {
			return "该组已经存在！";
		}
	},
	GROUP_NOT_EXIST {
		@Override
		public int getCode() {
			return 20602;
		}

		@Override
		public String getMessage() {
			return "该组不存在！";
		}
	},
	GROUP_DEFAULT {
		@Override
		public int getCode() {
			return 20603;
		}

		@Override
		public String getMessage() {
			return "该组为默认组！";
		}
	},
	CONTENT_DELETE {
		@Override
		public int getCode() {
			return 30001;
		}

		@Override
		public String getMessage() {
			return "该视频已经被删除，不能进行操作";
		}
	},
	CONTENT_NOT_UPLOAD {
		@Override
		public int getCode() {
			return 30002;
		}

		@Override
		public String getMessage() {
			return "该视频还没上传成功";
		}
	},
	CONTENT_META_NOT_UPLOAD {
		@Override
		public int getCode() {
			return 30003;
		}

		@Override
		public String getMessage() {
			return "该视频描述信息还没上传成功";
		}
	},
	CONTENT_META_NOT_EXIST {
		@Override
		public int getCode() {
			return 30004;
		}

		@Override
		public String getMessage() {
			return "该视频描述信息不存在";
		}
	},
	CONTENT_PART_ERROR {
		@Override
		public int getCode() {
			return 30005;
		}

		@Override
		public String getMessage() {
			return "分段上传失败！";
		}
	},
	USER_NICKNAME_DEFAULT_ERROR {
		@Override
		public int getCode() {
			return 30006;
		}

		@Override
		public String getMessage() {
			return "昵称不能包含趣拍二字！";
		}
	},
	USER_NICKNAME_BLANK_ERROR {
		@Override
		public int getCode() {
			return 30007;
		}

		@Override
		public String getMessage() {
			return "昵称不能为空！";
		}
	},
	LIVE_ONLINE_LIMIT {
		@Override
		public int getCode() {
			return 40001;
		}

		@Override
		public String getMessage() {
			return "同时只能一个直播在进行！";
		}
		
	},
	LIVE_TRAILER_LIMIT {
		@Override
		public int getCode() {
			return 40002;
		}

		@Override
		public String getMessage() {
			return "同时只能一个预告直播！";
		}
		
	}
	;

	/**
	 * 得到操作结果编码
	 *
	 * @return
	 */
	public abstract int getCode();

	/**
	 * 得到操作结果结果描述
	 *
	 * @return
	 */
	public abstract String getMessage();

}
