import Configuration from '../configurations/configuration';

class OrderService{

    constructor(){
        this.config = new Configuration();
    }

    async fetchUserOrders(){
        const userName = localStorage.getItem("username");
        console.log(userName);
        let orders = [];
        console.log(`${this.config.BASE_URL}orders/${userName}`);
        await fetch(
            `${this.config.BASE_URL}/orders/${userName}`,
            {
              headers: {
                "Content-type": "application/json",
              },
              method: "GET",
            }
          )
            .then(async (response) => {
              const data = await response.json();
              orders = data;
              console.log(orders);
            })
            .catch((error) => console.log(error));
        return orders;
    }

    async placeOrder(order){
        const userName = localStorage.getItem("username");
        var response = "Failed"
        await fetch(
            `${this.config.BASE_URL}/createOrder?userName=${userName}`,
            {
              headers: {
                "Accept":"application/json",
                "Content-type": "application/json",
              },
              method: "POST"
            }
            )
            .then((data) => {
              console.log(data);
              if(data.status === 200){
                  response = "Success"
              }
            })
            .catch((error) => {
                console.log("Failed to place an order");
                console.log(error);
            }
        );
        console.log(response);
        return response;
    }
}

export default OrderService;