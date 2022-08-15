package com.nam.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nam.dto.GroupFormForCreating;
import com.nam.dto.GroupFormForUpdating;
import com.nam.dto.filter.GroupFilter;
import com.nam.entity.Group;

public interface IGroupService {

	Page<Group> getAllGroups(Pageable pageable, GroupFilter filter, String search);

	boolean isGroupExistsByName(String name);

	void createGroup(GroupFormForCreating form);

	Group getGroupByID(short id);

	void updateGroup(short id, GroupFormForUpdating form);

	void deleteGroups(List<Short> ids);
}
