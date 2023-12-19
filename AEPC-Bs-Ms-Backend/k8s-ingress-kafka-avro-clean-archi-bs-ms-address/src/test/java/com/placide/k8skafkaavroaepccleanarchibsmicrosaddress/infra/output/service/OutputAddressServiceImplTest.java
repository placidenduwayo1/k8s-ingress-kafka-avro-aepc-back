package com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.output.service;

import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.domain.beans.Address;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.domain.exceptions.AddressNotFoundException;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.output.mapper.AddressMapper;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.output.models.AddressDto;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.output.models.AddressModel;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.output.repository.AddressRepository;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.output.service.OutputAddressServiceImpl;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.domain.avrobean.AddressAvro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

class OutputAddressServiceImplTest {
    @Mock
    private AddressRepository addressRepositoryMock;
    @InjectMocks
    private OutputAddressServiceImpl underTest;
    private Address address;
    private AddressAvro addressAvro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address = new Address.AddressBuilder()
                .addressId(UUID.randomUUID().toString())
                .num(184)
                .street("Avenue de Liège")
                .poBox(59300)
                .city("Valenciennes")
                .country("France")
                .build();
        addressAvro = AddressAvro.newBuilder()
                .setAddressId(address.getAddressId())
                .setNum(address.getNum())
                .setStreet(address.getStreet())
                .setPoBox(address.getPoBox())
                .setCity(address.getCity())
                .setCountry(address.getCountry())
                .build();
    }

    @Test
    void consumeAddressAdd() {
        //PREPARE
        //EXECUTE
        Address address = underTest.consumeAddressAdd(addressAvro, "topic1");
        //VERIFY
        Assertions.assertNotNull(address);
    }

    @Test
    void saveInDbConsumedAddress() {
        //PREPARE
        AddressModel addressModel = AddressMapper.mapBeanToModel(address);
        AddressModel savedModel = AddressMapper.mapBeanToModel(address);
        //EXECUTE
        Mockito.when(addressRepositoryMock.save(addressModel)).thenReturn(savedModel);
        Address actualAddress = underTest.saveInDbConsumedAddress(address);
        //VERIFY
        Assertions.assertAll("gpe of assertions",
                () -> Mockito.verify(addressRepositoryMock, Mockito.atLeast(1)).save(savedModel),
                () -> Assertions.assertEquals("Valenciennes", actualAddress.getCity()));
    }

    @Test
    void findAddressByInfo() {
        //PREPARE
        int num = 184;
        String street = "Avenue de Liège";
        int poBox = 59300;
        String city = "Valenciennes";
        String country = "France";
        AddressModel addressVal = AddressModel.builder()
                .addressId(UUID.randomUUID().toString())
                .num(num)
                .street(street)
                .poBox(poBox)
                .city(city)
                .country(country)
                .build();

        List<AddressModel> models = List.of(addressVal);

        AddressDto addressDto = new AddressDto(num, street, poBox, city, country);
        //EXECUTE
        Mockito.when(addressRepositoryMock.findByNumAndStreetAndPoBoxAndCityAndCountry(num, street, poBox, city, country)).thenReturn(models);
        List<Address> actualList = underTest.findAddressByInfo(addressDto);
        //VERIFY
        Assertions.assertAll("gpe of assertions",
                () -> Mockito.verify(addressRepositoryMock, Mockito.atLeast(1))
                        .findByNumAndStreetAndPoBoxAndCityAndCountry(num, street, poBox, city, country),
                () -> Assertions.assertEquals(1, actualList.size()));
    }

    @Test
    void getAllAddresses() {
        //PREPARE
        AddressModel addressVal = AddressModel.builder()
                .addressId(UUID.randomUUID().toString())
                .num(184)
                .street("Avenue de Liège")
                .poBox(59300)
                .city("Valenciennes")
                .country("France")
                .build();

        AddressModel addressParis = AddressModel.builder()
                .addressId(UUID.randomUUID().toString())
                .num(44)
                .street("Rue Notre Dame des Victoires")
                .poBox(74002)
                .city("Paris")
                .country("France")
                .build();

        List<AddressModel> addressModels = List.of(addressVal, addressParis);

        //EXECUTE
        Mockito.when(addressRepositoryMock.findAll())
                .thenReturn(addressModels);
        List<Address> actualAddresses = underTest.getAllAddresses();
        //VERIFY
        Assertions.assertAll("gpe of assertions",
                () -> Mockito.verify(addressRepositoryMock, Mockito.atLeast(1)).findAll(),
                () -> Assertions.assertEquals(2, actualAddresses.size()));
    }

    @Test
    void getAddress() throws AddressNotFoundException {
        //PREPARE
        Optional<AddressModel> addressVal = Optional.of(AddressModel.builder()
                        .addressId(UUID.randomUUID().toString())
                        .num(184)
                        .street("Avenue de Liège")
                        .poBox(59300)
                        .city("Valenciennes")
                        .country("France")
                        .build());
        String id = "uuid-001";
        //EXECUTE
        Mockito
                .when(addressRepositoryMock.findById(id))
                .thenReturn(addressVal);
        Optional<Address> actualAddress = underTest.getAddress(id);
        //VERIFY
        Assertions.assertAll("gpe of assertions",
                () -> Mockito.verify(addressRepositoryMock, Mockito.atLeast(1)).findById(id),
                () -> Assertions.assertNotNull(actualAddress));
    }

    @Test
    void consumeAddressDelete() {
        //PREPARE
        //EXECUTE
        Address actual = underTest.consumeAddressDelete(addressAvro, "topic2");
        //VERIFY
        Assertions.assertNotNull(actual);
    }

    @Test
    void deleteAddress() throws AddressNotFoundException {
        //PREPARE
        String id = "uuid-001";
        AddressModel model = AddressMapper.mapBeanToModel(address);
        Optional<AddressModel> addressVal = Optional.of(model);

        //EXECUTE
        Mockito.when(addressRepositoryMock.findById(id)).thenReturn(addressVal);
        Address address = underTest.getAddress(id).orElseThrow(AddressNotFoundException::new);
        AddressAvro avro = AddressMapper.mapBeanToAvro(address);
        Address consumedAddress = underTest.consumeAddressDelete(avro, "topic2");
        String deletedAddress = underTest.deleteAddress(id);

        //VERIFY
        Assertions.assertAll("gpe of assertions",
                () -> Mockito.verify(addressRepositoryMock, Mockito.atLeast(1)).deleteById(consumedAddress.getAddressId()),
                () -> Assertions.assertNotNull(deletedAddress));
    }

    @Test
    void consumeAddressEdit() {
        //PREPARE
        //EXECUTE
        Address address = underTest.consumeAddressEdit(addressAvro, "topic3");
        //VERIFY
        Assertions.assertNotNull(address);
    }

    @Test
    void updateAddress() {
        //PREPARE
        Address addressVal = new Address.AddressBuilder()
                .addressId(UUID.randomUUID().toString())
                .num(184)
                .street("Avenue de Liège")
                .poBox(59300)
                .city("Valenciennes")
                .country("France")
                .build();

        AddressModel addressModel = AddressMapper.mapBeanToModel(addressVal);
        Address expectedAddress = new Address.AddressBuilder()
                .addressId(UUID.randomUUID().toString())
                .num(5)
                .street("Avenue de Liège")
                .poBox(59300)
                .city("Valenciennes")
                .country("France")
                .build();
        AddressModel expectedAddressModel = AddressMapper.mapBeanToModel(expectedAddress);
        //EXECUTE
        Mockito.when(addressRepositoryMock.save(addressModel)).thenReturn(expectedAddressModel);
        Address address = underTest.updateAddress(addressVal);
        //VERIFY
        Assertions.assertAll("gpe of assertions",
                () -> Mockito.verify(addressRepositoryMock, Mockito.atLeast(1)).save(addressModel),
                () -> Assertions.assertEquals(5, address.getNum()));
    }
    @Test
    void getAddressesOfGivenCity(){
        //PREPARE
        String city = "Valenciennes";
        Address address1 = new Address.AddressBuilder()
                .addressId("1L")
                .num(184)
                .street("Avenue de Liège")
                .poBox(59300)
                .city("Valenciennes")
                .country("France")
                .build();
        Address address2 = new Address.AddressBuilder()
                .addressId("2L")
                .num(2)
                .street("Avenue de Liège")
                .poBox(59300)
                .city("Valenciennes")
                .country("France")
                .build();
        List<Address> addresses = List.of(address1, address2);
        //EXECUTE
        List<AddressModel> addressModels = addresses.stream().map(AddressMapper::mapBeanToModel).toList();
        Mockito.when(addressRepositoryMock.findByCity(city)).thenReturn(addressModels);
        List<Address> actuals = underTest.getAddressesOfGivenCity(city);
        //VERIFY
        Assertions.assertAll("assertions",()->{
            Mockito.verify(addressRepositoryMock, Mockito.atLeast(1)).findByCity(city);
            Assertions.assertEquals(addresses.size(), actuals.size());
        });
    }
}