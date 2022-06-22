package com.shop.supermarket;

import com.shop.supermarket.dto.Booksdto;
import com.shop.supermarket.dto.Customerdto;
import com.shop.supermarket.entity.Books;
import com.shop.supermarket.entity.Customer;
import com.shop.supermarket.repository.BooksRepository;
import com.shop.supermarket.repository.CustomerRepository;
import com.shop.supermarket.service.UserService;
import com.shop.supermarket.service.Bookservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookTest {

    private MockMvc mockMvc;

@Autowired
private Bookservice bookservice;
@Autowired
private UserService userService;

@MockBean
private BooksRepository booksRepository;

@MockBean
private CustomerRepository customerRepository;

@Autowired
private WebApplicationContext wac;


@Test
 void getId(){
    Books books=new Books();
    int expected=1;
    books.setId(1);
    Assertions.assertEquals(expected,books.getId());
}

@Test
 void getiddto()
{
    Booksdto booksdto=new Booksdto();
    int expected=1;
    booksdto.setId(1);
    Assertions.assertEquals(expected,booksdto.getId());
}


@Test
 void setId()
{
Books books=new Books();
int expected=1;
books.setId(1);
Assertions.assertEquals(expected,books.getId());
}

@Test
 void setIddto()
{
    Booksdto books=new Booksdto();
    int expected=1;
    books.setId(1);
    Assertions.assertEquals(expected,books.getId());
}


@Test
 void getName()
{
Books books=new Books();
String expected="hello";
books.setName("hello");
Assertions.assertEquals(expected,books.getName());
}

@Test
 void getNameDto()
{
    Booksdto books=new Booksdto();
    String expected="hello";
    books.setName("hello");
    Assertions.assertEquals(expected,books.getName());
}


//            System.out.println(itemsService.getbooks());
//            mockMvc.perform(MockMvcRequestBuilders.get("/staff/stockList"))
//                    .andExpect((MockMvcResultMatchers.model()).attribute("allItems",itemsService.getbooks()))
//                    .andExpect(MockMvcResultMatchers.view().name("stock-list"));



@Test
 void setName()
{
    Books books=new Books();
    String expected="hello";
    books.setName("hello");
    Assertions.assertEquals(books.getName(),expected);
}
@Test
 void setNameDto()
{
    Booksdto books=new Booksdto();
    String expected="hello";
    books.setName("hello");
    Assertions.assertEquals(books.getName(),expected);
}

@Test
 void getCost()
{
    Books books=new Books();
    int excepted=100;
    books.setCost(100);
    Assertions.assertEquals(excepted,books.getCost());
}
@Test
 void getCostDto()
{
    Booksdto books=new Booksdto();
    int excepted=100;
    books.setCost(100);
    Assertions.assertEquals(excepted,books.getCost());
}


@Test
 void toStringTest()
{
    String expected="Books{" +
            "id=" + 1 +
            ", name='" + "hello" + '\'' +
            ", cost=" + 100 +
            '}';

    Books books=new Books(1,"hello",100);
    Assertions.assertEquals(expected,books.toString());
}

@Test
 void toStringTestDto()
{
    String expected="Booksdto{" +
            "id=" + 1 +
            ", name='" + "hello" + '\'' +
            ", cost=" + 100 +
            '}';

    Booksdto books=new Booksdto(1,"hello",100);
    Assertions.assertEquals(expected,books.toString());
}







@Test
 void customergetid()
{
int expected=1;
    Customer customer=new Customer();
    customer.setId(1);
    Assertions.assertEquals(customer.getId(),expected);
}

@Test
 void customergetidDto()
{
    int expected=1;
    Customerdto customer=new Customerdto();
    customer.setId(1);
    Assertions.assertEquals(customer.getId(),expected);
}

@Test
 void customersetid()
{
    int expected=1;
    Customer customer=new Customer();
    customer.setId(1);
    Assertions.assertEquals(customer.getId(),expected);
}

@Test
 void customersetidDto()
{
    int expected=1;
    Customerdto customer=new Customerdto();
    customer.setId(1);
    Assertions.assertEquals(customer.getId(),expected);
}


@Test
 void customerusername() {
    String expected = "sahith";
    Customer customer = new Customer();
    customer.setUsername("sahith");
    Assertions.assertEquals(expected,customer.getUsername());
}
@Test
 void customerusernameDto() {
    String expected = "sahith";
    Customer customer = new Customer();
    customer.setUsername("sahith");
    Assertions.assertEquals(expected,customer.getUsername());
}



@Test
 void customerpassword()
{
    String expected="sahith";
    Customer customer=new Customer();
    customer.setPassword("sahith");
    Assertions.assertEquals(expected,customer.getPassword());
}

@Test
 void customerpasswordDto()
{
    String expected="sahith";
    Customerdto customer=new Customerdto();
    customer.setPassword("sahith");
    Assertions.assertEquals(expected,customer.getPassword());
}



@Test
 void customeraddress()
{
    String expected="hanamkonda";
    Customer customer=new Customer();
    customer.setAddress("hanamkonda");
    Assertions.assertEquals(expected,customer.getAddress());
}
@Test
 void customeraddressdto()
{
    String expected="hanamkonda";
    Customerdto customer=new Customerdto();
    customer.setAddress("hanamkonda");
    Assertions.assertEquals(expected,customer.getAddress());
}




@Test
 void customernumber()
{
    String expected="9381258216";
    Customer customer=new Customer();
    customer.setNumber("9381258216");
    Assertions.assertEquals(expected,customer.getNumber());
}

@Test
 void customernumberdto()
{
    String expected="9381258216";
    Customerdto customer=new Customerdto();
    customer.setNumber("9381258216");
    Assertions.assertEquals(expected,customer.getNumber());
}





@Test
 void customeremail()
{
    String expected="bandasahithreddy@gmail.com";
    Customer customer=new Customer();
    customer.setEmail("bandasahithreddy@gmail.com");
    Assertions.assertEquals(customer.getEmail(),expected);
}

@Test
 void customeremailDto()
{
    String expected="bandasahithreddy@gmail.com";
    Customerdto customer=new Customerdto();
    customer.setEmail("bandasahithreddy@gmail.com");
    Assertions.assertEquals(customer.getEmail(),expected);
}





@Test
 void toStringCustomer()
{
   String expected= "Customer{" +
            "id=" + 1 +
            ", username='" + "sahith" + '\'' +
            ", password='" + "password" + '\'' +
            ", email='" + "email" + '\'' +
            ", address='" + "address" + '\'' +
            ", number='" + "number" + '\'' +
            '}';

   Customer customer=new Customer(1,"sahith","password","email","address","number");
   Assertions.assertEquals(customer.toString(),expected);
}

@Test
 void tosting2Customer()
{
    String expected= "Customer{" +
            "id=" + 1 +
            ", username='" + "sahith" + '\'' +
            ", password='" + "password" + '\'' +
            ", email='" + "email" + '\'' +
            ", address='" + "address" + '\'' +
            ", number='" + "number" + '\'' +
            '}';

    Customer customer=new Customer("sahith","password","email","address","number");
    customer.setId(1);
    Assertions.assertEquals(customer.toString(),expected);

}


@Test
  void findall()
{
    when(booksRepository.findAll()).thenReturn(Stream.of(new Books(1,"Sahith",200),new Books(2,"hello",300) ).collect(Collectors.toList()));
    Assertions.assertEquals(2,bookservice.getbooks().size());

}

@Test
 void findById()
{
     int id=1;
     Books b=new Books(1,"hello",200);
     when(booksRepository.findById(1)).thenReturn(Optional.of(b));
     Assertions.assertEquals(b,bookservice.getBookById(1));

}

@Test
 void save(){
    Books books=new Books(1,"hello",300);
    verify(booksRepository,times(0)).save(books);
}

@Test
 void savecustomer(){
    Customer customer=new Customer(1,"sahith","sahith","sahith@gmail","hanamkond","9381258216");
    verify(customerRepository,times(0)).save(customer);
}
@Test
 void customerfindall()
{
    when(customerRepository.findAll()).thenReturn(Stream.of(new Customer(1,"sahith","sahith","sahith@gmail","hanamkond","9381258216"),new Customer(2,"sahith","sahith","sahith@gmail","hanamkond","9381258216")).collect(Collectors.toList()));
    Assertions.assertEquals(2,userService.getcustomers().size());

}
@Test
 void customerfindById()
{
    int id=1;
    Customer b=new Customer(1,"sahith","sahith","sahith@gmail","hanamkond","9381258216");
    when(customerRepository.findByUsername("sahith")).thenReturn(b);
    Assertions.assertEquals(b,userService.findByUsername("sahith"));

}


    @Test
    void stockListTesting() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/staff/stockList")).andExpect(status().is(200));
    }

    @Test
    void ordersList() throws Exception
    {
        MockMvc mockMvc=MockMvcBuilders.webAppContextSetup((this.wac)).build();
        mockMvc.perform(get("/user/order")).andExpect(status().is(200));
    }





    @Test
    void saveItem() throws Exception
    {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/staff/saveItem")).andExpect(status().is(405));
    }
    @Test
    void  deleteTest() throws Exception
    {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/staff/deleteItem").queryParam("id","1")).andExpect(status().is(405));
    }

    @Test
    void  updateTest() throws Exception
    {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/staff/updateItem").queryParam("id","1")).andExpect(status().is(405));
    }


    @Test
    void orderItem() throws  Exception
    {
        MockMvc mockMvc=MockMvcBuilders.webAppContextSetup((this.wac)).build();
        mockMvc.perform(get("/user/orderItem").queryParam("itemId","1")).andExpect(status().is(405));
    }







}
