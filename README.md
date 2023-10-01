# Fake Sushi Store API

This project is a REST API inspired by [FakeStore API](https://github.com/keikaavousi/fake-store-api) following the idea of offer a resource that can be helpful in the development of an e-commerce or shopping website projects.

# Why? 

The idea came with the need of learn how Spring Boot works so i decided to create a simple monolithic application that offers a similar service as FakeStore API but oriented in the food bussiness.

# Resources 
---

- Products
- Users
- Login JWT Token
- Carts 

# Accessing to resources 
---
Note: These paths are temporary while the system is under development. 

## Products 

The products resource returns a 45 items menu between sushi combos and single rolls.

### Get all products 

```
 api/v1/products 
```

### Get single product 

```
api/v1/products/1
```

### Add new product

```
fetch("http://localhost:8080/api/v1/products", {
  method: "POST",
  body: JSON.stringify({
    name: "test combo",
    price: 4000,
    category: "combos/salmon",
    description: "lorem impsum dolor"
    image: "https://picsum.photos/200",
  }),
})
  .then((res) => res.json())
  .then((json) => console.log(json));

/* Will return

{
    "data": {
        "id": 45,
        "name": "Testing Combo",
        "price": 4000.0,
        "category": "combos / salmon",
        "description": "Test description",
        "image": "www.test-image.com"
    },
    "message": "Product successfully saved"
}
*/
```
