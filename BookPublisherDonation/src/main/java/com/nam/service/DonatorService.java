package com.nam.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nam.dto.DonatorPostDTO;
import com.nam.entity.Donator;
import com.nam.entity.Donator_Post;
import com.nam.entity.Post;
import com.nam.repository.IDonatorPostRepository;
import com.nam.repository.IDonatorRepository;
import com.nam.repository.IPostRepository;

@Service
public class DonatorService implements IDonatorService {

	@Autowired
	private IDonatorRepository repository;

	@Autowired
	private IDonatorPostRepository Dprepository;
	@Autowired
	private IPostRepository PostRepository;

	@Override
	public ArrayList<Donator> getAllDonator() {

		return (ArrayList<Donator>) repository.findAll();
	}

	@Override
	public void createDonatePost(int donatorId, int postId, String mess, int money) {
		Donator_Post donatorPost = new Donator_Post();
		Post post = new Post(postId);
		Donator donator = new Donator(donatorId);
		donatorPost.setDonator(donator);
		donatorPost.setPost(post);
		donatorPost.setMessage(mess);
		donatorPost.setTotal_money(money);
		Dprepository.save(donatorPost);

		PostRepository.extraMoney(postId, money);
	}

	@Override
	public Donator findDonatorByPhone(String phone) {
		Donator donator = repository.findAllByPhone(phone);
		return donator;
	}

	@Override
	public void createDonator(DonatorPostDTO dto) {
		Donator donator = new Donator(dto.getPhone(), dto.getFullName(), dto.getEmail(), dto.getAddress());
		repository.save(donator);

	}

}
