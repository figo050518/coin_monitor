package com.chelp.oop.sys;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = false)
@Lazy(false)
public class UserInfoTaskService{
	
//	@Autowired
//	private UserInfoDao userInfoDao;
//	@Autowired
//	private UserInfoService userInfoService;
//	@Transactional(readOnly = false)
//	@Scheduled(cron ="0 0 2 ? * *" )
//	public void userCardCheck() throws  Exception{
//		UserInfo user = new UserInfo();
//		user.setIsMember("1");
//		List<UserInfo> userInfoList  = userInfoDao.findList(user);
//		List<String> tarList = Lists.newArrayList();
//		for (UserInfo userInfo : userInfoList) {
//			if(userInfo.getStatus().equals("2")){
//				String endTime =userInfo.getMemberEndTime();
//				Date end = DateUtils.weeHours(DateUtils.parseDate(endTime),1);
//				if(end.after(new Date())){
//					tarList.add(userInfo.getId());
//				}
//			}
//		}
//		userInfoService.batchOffline(tarList);
//	}

	


}
