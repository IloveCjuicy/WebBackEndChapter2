package com.example.webbackendexperiment2.Cotroller;

import com.example.webbackendexperiment2.Mapper.GoodMapper;
import com.example.webbackendexperiment2.Mapper.UserMapper;
import com.example.webbackendexperiment2.Model.Good;
import com.example.webbackendexperiment2.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/good")
public class Controller1
{
    @Autowired
    GoodMapper goodMapper;
    @Autowired
    UserMapper userMapper;

    @GetMapping(value = "/user")
    public String logIn(@RequestParam(value = "username")String username, @RequestParam(value = "password") String password)
    {

        List<User> users = userMapper.findAllUsers();
        for(User u: users)
        {
            if(u.getPassword().equals(password)&&u.getUsername().equals(username))
                return "信息正确";
        }
        return "信息有误";
    }

    @GetMapping("/goodlist/goodlistall")
    public String ListAllGood()
    {
        List<Good> all_goods= goodMapper.findAllGoods();
        return all_goods.toString();
    }

    @PostMapping ("/goodlist/good")
    public Good AddGood(@RequestParam(value = "goodname")String goodname,@RequestParam(value = "price")double price,@RequestParam(value = "stock")int stock)
    {
        Good new_good = new Good(goodname,price,stock);
        goodMapper.insertGood(goodname,price,stock);
        return new_good;
    }

    @RequestMapping(value = "/goodlist/{goodname}",method = RequestMethod.PUT)
    public String ModifyGood(@PathVariable String goodname,@RequestParam(value = "price") double price,@RequestParam(value = "stock")int stock)
    {
        Good modified_good = new Good(goodname,price,stock);
        goodMapper.updateByGoodName(price,stock,goodname);
        return modified_good.toString();

    }

    @RequestMapping(value = "/goodlist/good",method = RequestMethod.DELETE)
    public String DeleteGood(@RequestParam(value = "id")int id)
    {
        Good deleted_good=goodMapper.selectById(id);
        goodMapper.deleteById(id);
        return deleted_good.toString();
    }

}
