import Configuration from "../configurations/configuration";
class useFetch{

  handleadd=(users)=>{
    const config=new Configuration();
    const url=config.BASE_URL+"/user/register";
    fetch(url,{
        method:'POST',
        headers:{"Content-Type":"application/json"},
        body: JSON.stringify(users)
    }).then((response)=>{
      if (!response.ok) {
        throw Error(response.statusText);
    }
       })
       .catch(function(error) {
        console.log(error);
       
       

})}
    handleAddToCar=(id,userName)=>{
    const config=new Configuration();
    const url=config.BASE_URL+"/cart/";
    fetch(`${url}?productId=${id}&userName=${userName}`,{
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            
        }).then(()=>{
            console.log("I am here at then");
        })
        alert('Item added to cart');
  }
  removeItem=(id,loadCart)=>
  { const config=new Configuration();
    const url=config.BASE_URL+"/cart/";
    fetch(`${url}${id}?id=${id}`, {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
    }).then(() => {
      console.log("remove");
      loadCart();
    });
  }
  handleAddTC=(id,userName)=>
  { 
    const config=new Configuration();
    const url=config.BASE_URL+"/cart";
    fetch(`${url}?productId=${id}&userName=${userName}`,{
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        
    }).then(()=>{
        console.log("I am here at then");
    })
    alert('Item added to cart');
  }
  changecount=(incrementFlag,id,loadCart)=>
  {
    const config=new Configuration();
    const url=config.BASE_URL+"/cart/";
    fetch(
      `${url}${id}?increment=${incrementFlag}&id=${id}`,
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
      }
    ).then(() => {
      console.log("increment");
      loadCart();
    });
  }
  handleup=(data)=>
  {
    const config=new Configuration();
    const url=config.BASE_URL+"/user/profile";
    fetch(url, {
      method: 'PUT',
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    }).then(() => {
   //   // history.go(-1);
   // //   history.push('/');
    })
    alert('Data updated successfully!!');
  }

  async handleLogin(userlog){
    const config=new Configuration();
    const url=config.BASE_URL+"/user/login";
    return (fetch(url, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(userlog)
}).then((response)=> {
  if(!response.ok)
  {
    throw Error(response.statusText);
}
 return response.json();
}))
.catch(function(error) {
  console.log(error);
 
 

})}
 

  }


 
export default useFetch;