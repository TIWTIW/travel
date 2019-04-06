package nju.agile.travel.controller;

import nju.agile.travel.model.PostInfoParam;
import nju.agile.travel.service.PostService;
import nju.agile.travel.vo.PostBaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by echo on 2019/1/14.
 */
//访问路径控制
@RestController
public class PostController {

    @Autowired
    PostService postService;
    //返回任务表单
    @GetMapping("/activity/{activityId}/post")
    public List<PostBaseVO> getActivityPostList(@PathVariable Integer activityId){
        return postService.queryPost(activityId);
    }

    //返回用户
    @PostMapping("/user/{userId}/activity/{activityId}/post")
    public int userPost(@PathVariable Integer userId,
                        @PathVariable Integer activityId,
                        @RequestBody @Valid PostInfoParam param){
        System.out.println(param.getContent());
        param.setAuthorId(userId);
        param.setActivityId(activityId);
        return postService.post(param);
    }
}
