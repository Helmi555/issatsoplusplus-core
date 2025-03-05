package com.university.forum.usermanagement.ClassGroupManagement.Services;


import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Request.BranchRequestDto;
import com.university.forum.usermanagement.ClassGroupManagement.Dtos.Response.BranchResponseDto;

import java.util.List;

public interface BranchService {

    BranchResponseDto createBranch(BranchRequestDto branchRequestDto);

    List<BranchResponseDto> getAllBranches();

    BranchResponseDto getBranchById(int id);
}
