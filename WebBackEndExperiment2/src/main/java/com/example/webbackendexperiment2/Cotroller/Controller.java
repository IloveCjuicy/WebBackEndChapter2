package com.example.webbackendexperiment2.Cotroller;

import com.example.webbackendexperiment2.Entity.Good;
import com.example.webbackendexperiment2.Entity.User;
import com.example.webbackendexperiment2.Service.IGoodService;
import com.example.webbackendexperiment2.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/good")
public class Controller
{
    @Autowired
    IGoodService goodService;

    @Autowired
    IUserService userService;

    @GetMapping(value = "/user")
    public String logIn(@RequestParam(value = "username")String username, @RequestParam(value = "password") String password)
    {

        List<User> users = userService.findAllUsers();
        for(User u: users)
        {
            if(u.getPassword().equals(password)&&u.getUsername().equals(username))
                return "信息正确";
        }
        return "信息有误";
    }
    @GetMapping(value = "/goodlist/findgood")
    public Good FindGoodById(@RequestParam(value = "id") Integer id)
    {
        return goodService.findById(id);
    }

    @GetMapping("/goodlist/goodlistall")
    public String ListAllGood()
    {
        List<Good> all_goods= goodService.findAllGoods();
        return all_goods.toString();
    }
    //在浏览器url输入默认是getmapping，需要在此处改为post
    @RequestMapping(value = "/goodlist/good",method = RequestMethod.POST)
    public Good AddGood(@RequestParam(value = "goodname")String goodname,@RequestParam(value = "price")double price,@RequestParam(value = "stock")int stock)
    {
        Good new_good = new Good(goodname,price,stock);
        goodService.insertGood(goodname,price,stock);
        return new_good;
    }

    @RequestMapping(value = "/goodlist/{goodname}",method = RequestMethod.PUT)
    public String ModifyGood(@PathVariable String goodname,@RequestParam(value = "price") double price,@RequestParam(value = "stock")int stock)
    {
        Good modified_good = new Good(goodname,price,stock);
        goodService.updateByGoodName(price,stock,goodname);
        return modified_good.toString();

    }

    @RequestMapping(value = "/goodlist/good",method = RequestMethod.DELETE)
    public int DeleteGood(@RequestParam(value = "id")int id)
    {
        return goodService.deleteById(id);
    }

}
