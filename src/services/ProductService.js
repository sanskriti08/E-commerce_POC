import Configuration from '../configurations/configuration';

class ProductService{

    constructor(){
        this.config = new Configuration();
    }

    async fetchProducts(){
        let products = [];
        await fetch(
            `${this.config.BASE_URL}/product/details`,
            {
              headers: {
                "Content-type": "application/json",
              },
              method: "GET",
            }
          )
            .then(async (response) => {
              const data = await response.json();
              products = data;
              console.log("at then"+products);
            })
            .catch((error) => console.log(error));
        return products;
    }

    
}

export default ProductService;