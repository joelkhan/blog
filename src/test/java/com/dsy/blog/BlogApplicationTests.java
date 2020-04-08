package com.dsy.blog;

import com.dsy.blog.mapper.BlogMapper;
import com.dsy.blog.po.Blog;
import com.dsy.blog.po.Tag;
import com.dsy.blog.po.Type;
import com.dsy.blog.service.BlogService;
import com.dsy.blog.service.TagService;
import com.dsy.blog.service.TypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.management.GarbageCollectorMXBean;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;


    @Autowired
    private BlogMapper blogMapper;

    @Test
    void testGetTypeByName(){
        Type type = typeService.getTypeByName("1");
        System.out.println(type);

    }


    @Test
    public void getTagByName(){
        Tag tag = tagService.getTagByTagName("Redis");
        System.out.println(tag);
    }


    @Test
    public void getBlogsByPage(){
//        Type type = new Type();
//        type.setName("杜世银");
//        Blog blog = new Blog();
//        blog.setType(type);
//        PageHelper.startPage(1,10);
//        Page<Blog> blogs = blogService.findBlogByPage(blog);
//        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
//        System.out.println(blogs);
    }


    @Test
    public void testOneToOne(){
        List<Blog> blogList = blogMapper.findBlogAll();
        System.out.println(blogList);
    }

    @Test
    public void testFindBlogsByIds(){
        String ids = "1,2";
        List<Tag> tags = tagService.listTag(ids);
        System.out.println(tags);
    }


    @Test
    public void selectBlogByKeyWords(){
        Page<Blog> blogs = blogService.selectBlogByKeyWords("条件", null, null);
        System.out.println(blogs);
    }

    @Test
    public void findBlogByKeyWords(){
        List<Blog> blogList = blogMapper.findBlogByKeyWords("条件", "12", "1");
        System.out.println(blogList);
    }

    @Test
    public void findTagsByBlogId(){
        String tags = blogService.findTagsByBlogId(8);
        System.out.println(tags);
    }

    @Test
    public void deleteBlog(){
        blogService.deleteBlog(12);
    }
}