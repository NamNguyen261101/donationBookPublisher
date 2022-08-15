package com.nam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nam.dto.PostDTO;
import com.nam.entity.Post;
import com.nam.repository.IPostRepository;

@Service
public class PostService implements IPostService {

	@Autowired
	private IPostRepository repository;

	@Override
	public ArrayList<Post> getAllPost() {

		return (ArrayList<Post>) repository.findAll();
	}

	@Override
	public Post getPostByID(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void createPost(PostDTO form) {
		repository.save(form.toEntity());

	}

	@Override
	public void updatePost(int id, PostDTO form) {
		Post entity = repository.findById(id).get();
		entity.setTitle(form.getTitle());
		entity.setContent_1(form.getContent_1());
		entity.setContent_2(form.getContent_2());
		entity.setImg_1(form.getImg_1());
		entity.setImg_2(form.getImg_2());
		entity.setPlanBudget(form.getPlanBudget());
		repository.save(entity);
	}

	@Transactional
	public void deletePost(List<Integer> ids) {
		repository.deleteByIdIn(ids);

	}

}
