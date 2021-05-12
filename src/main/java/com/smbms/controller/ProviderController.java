package com.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.smbms.pojo.Provider;
import com.smbms.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/Provider")
@Controller
public class ProviderController {
    @Autowired
    ProviderService providerService;
    /**
     * 添加
     * @param provider
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method= RequestMethod.POST)
    public String addProvider(@ModelAttribute("provider") Provider provider, Model model){
        if(providerService.addProvider(provider)>0){
            model.addAttribute("provider",provider );
            return "redirect:/Provider/";
        }
        return "../../register";
    }
    /**
     * 查询所有
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String query(Model model){
        model.addAttribute("list",providerService.getAllProviderListByPage());
        return "details";
    }
    /**
     * 修改
     * @param provider
     * @return
     */
    @RequestMapping(value = "/" , method = RequestMethod.PUT)
    public String updateProviderById(  Provider provider){
        providerService.updateProvide(provider) ;
        return "redirect:/Provider/";
    }
    /**
     * 根据id查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String queryById(@PathVariable Integer id,Model model,String proCode){
        model.addAttribute("list" ,  providerService.getAllProviderListById(id));
        if(proCode!=null) return "update";
        return "details";
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public String delProviderById(@PathVariable Integer id){
        providerService.delProviderById(id) ;
        return "redirect:/Provider/";
    }

    /**
     * 验证供应商编码
     * @param proCode
     * @return
     */
    public @RequestMapping(value = "/checkProCode") @ResponseBody String checkProCode(@RequestParam String proCode) {
        return JSON.toJSONString(providerService.getProviderByProCode(proCode));
    }


//    @RequestMapping(value = "success2.do")
//    public String success(){
//        return "success";
//    }
//    @RequestMapping("yc")
//    public String yc(@RequestParam(defaultValue = "1") Integer id) throws Exception {
//        if(id==1){
//            int a=1/0;
//        }else  if(id==2){
//            throw new SQLException("模拟SQL异常");
//        }else {
//            throw new Exception("模拟未知异常");
//        }
//        return "success";
//    }
}
