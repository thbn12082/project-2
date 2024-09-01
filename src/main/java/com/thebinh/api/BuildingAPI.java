package com.thebinh.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thebinh.model.BuildingDTO;
import com.thebinh.model.BuildingRequestDTO;
import com.thebinh.repository.entity.BuildingEntity;
import com.thebinh.repository.entity.DistrictEntity;
import com.thebinh.service.BuildingService;

@RestController
@PropertySource("classpath:application.properties")
@Transactional




public class BuildingAPI {
	@Autowired
    private BuildingService buildingService;
	
	@Value("${thebinh}")
	private String data;
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@GetMapping(value="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String,  Object> params,
			           						  @RequestParam (value = "typecode", required = false) ArrayList<String> typecode){
		List<BuildingDTO> result = buildingService.findAll(params, typecode);
		return result;
	}
	
	@PostMapping(value = "/api/building/")
	//@Transactional
	public String createBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName(buildingRequestDTO.getName());
		//buildingEntity.setbuildingRequestDTO.getDistrictid();
		//phải làm riêng 1 cái cho DistrictEntity vì nó là 1 entity riêng biệt
		
		DistrictEntity districtEntity = new DistrictEntity();
		districtEntity.setId(buildingRequestDTO.getDistrictid());
		
		buildingEntity.setDistrict(districtEntity);
		buildingEntity.setFloorarea(buildingRequestDTO.getFloorarea());
		buildingEntity.setNumberofbasement(buildingRequestDTO.getNumberofbasement());
		buildingEntity.setRentprice(buildingRequestDTO.getRentprice());
		buildingEntity.setStreet(buildingRequestDTO.getStreet());
		buildingEntity.setWard(buildingRequestDTO.getWard());
		String sql = "FROM Building b";
		entityManager.persist(buildingEntity);
		return "ok roi nha";
	}
	
	@PutMapping(value = "/api/building/")
	//@Transactional
	public void updateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName(buildingRequestDTO.getName());
		//buildingEntity.setbuildingRequestDTO.getDistrictid();
		//phải làm riêng 1 cái cho DistrictEntity vì nó là 1 entity riêng biệt
		buildingEntity.setId(6L);
		DistrictEntity districtEntity = new DistrictEntity();
		districtEntity.setId(buildingRequestDTO.getDistrictid());
		
		buildingEntity.setDistrict(districtEntity);
		buildingEntity.setFloorarea(buildingRequestDTO.getFloorarea());
		buildingEntity.setNumberofbasement(buildingRequestDTO.getNumberofbasement());
		buildingEntity.setRentprice(buildingRequestDTO.getRentprice());
		buildingEntity.setStreet(buildingRequestDTO.getStreet());
		buildingEntity.setWard(buildingRequestDTO.getWard());
		String sql = "FROM Building b";
		entityManager.merge(buildingEntity);
	}
	
	
	
	@DeleteMapping(value="/api/building/{id}")
		public String deleteBuilding(@PathVariable Long id) {
			BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, id);
			entityManager.remove(buildingEntity);

			return "Đã xóa tòa nhà số 8 rồi nhá" ;
			// lúc này trong db đã xóa tòa nhà số 6 rồi, và, tòa nhà số 7 vẫn giữ nguyên id nhé
			// khi xóa sẽ không tự động xóa các building có liên quan
		}
	
}