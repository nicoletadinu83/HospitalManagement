package HospitalManagement.com.HospitalMAnagement.service;

import HospitalManagement.com.HospitalMAnagement.dto.AddressDto;

import java.util.List;

public interface AdressService {

    public List<AddressDto> getAllAddress();

    public AddressDto getAddressByID(Long id);

    public void deleteAddress(Long id);

    public void addAddress(AddressDto addressDto);

    public void updateAdreess(AddressDto addressDto);
}
