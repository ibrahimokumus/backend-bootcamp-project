package com.kodlamaio.kodlamaio.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.kodlamaio.business.abstracts.BlackListService;
import com.kodlamaio.kodlamaio.business.request.CreateBlackListRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateBlackListRequest;
import com.kodlamaio.kodlamaio.business.response.CreateBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.GetBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateBlackListResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/blacklist")
public class BlackListController {

	private BlackListService blackListService;
	
	@GetMapping("/{id}")
	public DataResult<GetBlackListResponse> getById(@PathVariable int id){
		return this.blackListService.getById(id);
	}
	
	@GetMapping
	public DataResult<List<GetAllBlackListResponse>> getAll() {
		return this.blackListService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DataResult<CreateBlackListResponse> add(@RequestBody CreateBlackListRequest createBlackListRequest) {
		return this.blackListService.add(createBlackListRequest);
	}
	
	@PutMapping
	public DataResult<UpdateBlackListResponse> Update (@RequestBody UpdateBlackListRequest updateBlackListRequest){
		return this.blackListService.Update(updateBlackListRequest);
		
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.blackListService.delete(id);
	}
	
	
	
	
	
	
}
