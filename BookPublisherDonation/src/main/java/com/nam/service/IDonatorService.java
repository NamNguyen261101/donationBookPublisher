package com.nam.service;

import java.util.ArrayList;

import com.nam.dto.DonatorPostDTO;
import com.nam.entity.Donator;

public interface IDonatorService {

	ArrayList<Donator> getAllDonator();

	void createDonatePost(int donatorId, int postId, String mess, int money);

	Donator findDonatorByPhone(String phone);

	void createDonator(DonatorPostDTO dto);

}
