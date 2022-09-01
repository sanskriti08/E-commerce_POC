import Configuration from '../configurations/configuration';

class CartService{

    constructor(){
        this.config = new Configuration();
    }

    async fetchUserCart(){
        const userName = localStorage.getItem("username");
        console.log(userName);
        let cart = [];
        console.log(`${this.config.BASE_URL}/cart?userName=${userName}`);
        await fetch(
            `${this.config.BASE_URL}/cart?userName=${userName}`,
            {
              headers: {
                "Content-type": "application/json",
              },
              method: "GET",
            }
          )
            .then(async (response) => {
              const data = await response.json();
              cart = data;
              console.log(cart);
            })
            .catch((error) => console.log(error));
        return cart;
    }

    async placeOrder(order){
        const userName = localStorage.getItem("username");
        var response = "Failed"
        await fetch(
            `${this.config.BASE_URL}/createOrder/${userName}`,
            {
              headers: {
                "Accept":"application/json",
                "Content-type": "application/json",
              },
              method: "POST",
              body: JSON.stringify(order)
            }
            )
            .then((data) => {
              if(data.status === 200){
                  response = "Success"
              }
            })
            .catch((error) => {
                console.log("Failed to place an order");
                console.log(error);
            }
        );
        return response;
    }
}

export default CartService;