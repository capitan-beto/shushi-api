# Fake Sushi Store API

This project is a REST API inspired by [FakeStore API](https://github.com/keikaavousi/fake-store-api) following the idea of offer a resource that can be helpful in the development of an e-commerce or shopping website projects.

# Why? 

The idea came with the need of learn how Spring Boot works so i decided to create a simple monolithic application that offers a similar service as FakeStore API but oriented in the food bussiness.

# Resources 

- Products
- Users
- Login JWT Token
- Carts 

# Accessing to resources 

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

```js
fetch("/api/v1/products", {
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

/* returns
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

### Updating a product 

```js
fetch("/api/v1/products", {
  method: "PUT",
  body: JSON.stringify({
    id: 1,
    name: "Full Salmon x15 Updated",
    price: 4000,
    category: "combos/ salmon",
    description: "15 pieces of Sake, Cream Roll, Salmon Maki, Feel Roll",
    image: "www.imagen.com/salmonx15"
  })
})
  .then((res) => res.json())
  .then((json) => console.log(json));

/* returns
    "data": {
        "id": 1,
        "name": "Full Salmon X15 Edited",
        "price": 4000.0,
        "category": "combos / salmon",
        "description": "15 pieces of Sake, Cream Roll, Salmon Maki, Feel Roll",
        "image": "www.imagen.com/salmonx15"
    },
    "message": "Product successfully updated"
*/
```

### Delete product

```js
[DELETE] /api/v1/products/1 

/* returns
{
    "message": "Product successfully deleted"
}
```

### Limit results 

Results can be limited using query strings

```js
/api/v1/products?limit=5
```

## Types and available routes 

### Products 

```js
{
    id: Number,
    name: String,
    price: Number,
    category: Number,
    description: String,
    image: String
}
```
GET: 

- /api/v1/products (Get all products)
- /api/v1/products/1 (Get single product)
- /api/v1/products?limit=10 (Limit products response)
- /api/v1/products/categories (Get categories list)
- /api/v1/products/categories/veggie (Get products in specific category)

POST: 

- /products 

PUT: 

- /products

DELETE: 

- /products/1
