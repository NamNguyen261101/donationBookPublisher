package com.nam.service;

import java.util.ArrayList;
import java.util.List;

import com.nam.dto.PostDTO;
import com.nam.entity.Post;

public interface IPostService {

	ArrayList<Post> getAllPost();

	Post getPostByID(int id);

	void createPost(PostDTO form);

	void updatePost(int id, PostDTO form);

	void deletePost(List<Integer> ids);

}
