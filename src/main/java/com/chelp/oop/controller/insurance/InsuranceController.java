package com.chelp.oop.controller.insurance;

import com.chelp.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/insurance/view")
public class InsuranceController extends BaseController {

//
//	@Autowired
//	private AccountFlowService accountFlowService;
//	@Autowired
//	private AccountPayService accountPayService;
//	@Autowired
//	private InsuranceService insuranceService;
//	@Autowired
//	private SettleApplyMapper settleApplyDao;
//	@Autowired
//	private CoinInfoService settleApplyService;
//	@Autowired
//	private PayOrderMapper payOrderMapper;
//	//申请列表
//    @RequestMapping(value = "list", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResponseData list(@RequestBody AccountFlow accountFlow) throws  Exception {
//    	PaginationBean<AccountFlow> userPage = accountFlowService.findListPage(new PaginationBean<AccountFlow>(accountFlow.getPageIndex(),accountFlow.getPageSize()),accountFlow);
//    	if(userPage!=null){
//    		for (AccountFlow af : userPage.getList()) {
//    			if(af.getPdfUrl()!=null && !af.getPdfUrl().isEmpty()){
//    				 String output = URLDecoder.decode(af.getPdfUrl(), "UTF-8");
//    				 af.setPdfUrl(output);
//    			}
//			}
//    	}
//        return ResponseData.success(userPage);
//    }
//
//
//  //查看提现记录 参数是 userId
//    @RequestMapping(value = "settleList", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResponseData settleList(@RequestBody AccountFlow accountFlow) throws  Exception {
//    	PaginationBean<AccountFlow> accountFlowPage = accountFlowService.findByUserPage(new PaginationBean<AccountFlow>(accountFlow.getPageIndex(),accountFlow.getPageSize()),accountFlow);
//        return ResponseData.success(accountFlowPage);
//    }
//
//
//  //提现操作
//    @RequestMapping(value = "settleByUser", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResponseData settleByUser(@RequestBody SettleApply settleApply) throws  Exception {
//    	SysUser user = UserUtils.getCurrentUser();
//    	PayAccount accountPay = accountPayService.findByUser(settleApply.getUserId());
//    	//插入申请
//    	Insurance insurance = new Insurance();
//    	insurance.setCoachId(String.valueOf(settleApply.getUserId()));
//    	insurance.setIsDelete("0");
//    	insurance.setApplyTime(new Date());
//    	insurance.setPayTime(new Date());
//    	insurance.setApplyId(settleApply.getId());
//    	insurance.setStatus("2");
//    	insurance.setType("2");
//    	insuranceService.insert(insurance);
//    	//生成流水
//    	AccountFlow  flow = new AccountFlow();
//    	flow.setUserId(settleApply.getUserId());
//    	String flowId = BiginsUtils.getAccountFlow();
//    	flow.setFlowId(flowId);
//    	flow.setFlowType("2");
//    	flow.setCreateTime(new Date());
//    	flow.setAccountChange(accountPay.getWaitSettleAmount());
//    	flow.setAccountTotal(accountPay.getWaitSettleAmount());
//    	flow.setOperateId(Integer.valueOf(user.getId()));
//    	flow.setDelFlag("0");
//    	flow.setDraw(accountPay.getWaitSettleAmount());
//    	flow.setInsuranceId(insurance.getId());
//    	accountFlowService.insert(flow);
//    	//更新账号余额
//     	accountPay.setSettledAmount(accountPay.getSettledAmount()+accountPay.getWaitSettleAmount());
//    	accountPay.setWaitSettleAmount(0.00);
//    	accountPay.setRecordWaitCount(0);
//    	accountPayService.settleUpdate(accountPay);
//    	//更新申请状态
//    	settleApply.setStatus("2");
//    	settleApplyDao.updateByPrimaryKeySelective(settleApply);
//    	//更新payorder
//    	PayOrder order = new PayOrder();
//    	order.setHasSettle("1");
//    	order.setUserId(settleApply.getUserId());
//    	payOrderMapper.updateSettleByUser(order);
//    	//提现申请状态更新
//    	settleApplyService.updateStatus("2",settleApply.getId());
//        return ResponseData.success();
//    }
//
//    //findByPayAccount
//    @RequestMapping(value = "findPayAccount", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResponseData findPayAccount(@RequestBody PayAccount payaccount) throws  Exception {
//    	if(!CodeHelper.isNotNullOrEmpty(payaccount.getUserId())){
//    		return ResponseData.success(BusinessCodeEnum.PARAMETER_DOES_NOT_EXIST.getMessage(),BusinessCodeEnum.PARAMETER_DOES_NOT_EXIST.getCode());
//    	}
//    	PayAccount payAccount = accountPayService.findByUser(payaccount.getUserId());
//        return ResponseData.success(payAccount);
//    }
//
//    //updatePayAccount
//    @RequestMapping(value = "updatePayAccount", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResponseData updatePayAccount(@RequestBody PayAccount payaccount) throws  Exception {
//    	if(!CodeHelper.isNotNullOrEmpty(payaccount.getUserId())){
//    		return ResponseData.success(BusinessCodeEnum.PARAMETER_DOES_NOT_EXIST.getMessage(),BusinessCodeEnum.PARAMETER_DOES_NOT_EXIST.getCode());
//    	}
//    	int i = accountPayService.update(payaccount);
//    	if(i>0){
//    		return ResponseData.success();
//    	}
//        return ResponseData.success();
//    }
//
//    //教练提现记录
//    @RequestMapping(value = "coachSettleRecord", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResponseData coachSettleRecord(@RequestBody PayAccount payaccount) throws  Exception {
//    	PaginationBean<PayAccount> payAccountPage = accountPayService.findListPage(new PaginationBean<PayAccount>(payaccount.getPageIndex(),payaccount.getPageSize()),payaccount);
//        return ResponseData.success(payAccountPage);
//    }
//
//    //申请列表
//    @RequestMapping(value = "settleApplyList", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResponseData settleApplyList(@RequestBody SettleApply settleApply) throws  Exception {
//    	PaginationBean<SettleApply> payAccountPage = settleApplyService.findListPage(new PaginationBean<SettleApply>(settleApply.getPageIndex(),settleApply.getPageSize()),settleApply);
//        return ResponseData.success(payAccountPage);
//    }
//
//

    
   


}


