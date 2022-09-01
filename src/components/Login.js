import {useState} from "react";
import {useHistory} from "react-router-dom";
import useFetch from "./useFetch";
import '../login.css'
const Login = ({set}) => {
    const [hidehead,setHide]=useState(window.location.pathname==="/login"?true:false);
    const usefe=new useFetch();
    if(hidehead===true){ setHide(false);set(); }
    const [userName,setUname]=useState('');
    const [password,setPass]=useState('');
    const history=useHistory();
    const handleLogin=(e)=>{
        e.preventDefault();
        const userlog={userName,password};
    usefe.handleLogin(userlog)
    .then(data=>{
     console.log(data);
 if(data.value==="name1")
 {    localStorage.setItem("username",userlog.userName);
localStorage.setItem("password",userlog.password);
history.push("/")

set();
 }
else{
document.getElementById("ab").innerHTML="Wrong credentials";
}
    })}
    //const bg = "C:\Users\riladkani\Desktop\poc-ui\ReactSpringBootPOC\public\images\watch.jpg"
    return ( 
       <div className="contains">
        <div class="login">
        
        <button class="button a4"
            
            onClick={(e) => {
            e.preventDefault();
            history.push("/signup");
        }}
        > Signup</button>
        <button class="button b4"
            
            onClick={(e) => {
            e.preventDefault();
            history.push("/login");
        }}
    >Login</button>
    
          <h2>Login form</h2>
          <form onSubmit={handleLogin}>
             
              <input class= "i"
              type="text"
              required
              placeholder="Enter Username"
              value={userName}
              onChange={(e)=>setUname(e.target.value)}
              />
              
              <input class= "i"
              type="password"
              required
              placeholder="Enter Password"
              value={password}
              onChange={(e)=>setPass(e.target.value)}
              />
              <p id="ab"></p>
              <button class="b3">Login</button>
              
          </form>
         
      </div>
      </div>
     
      );
}
 
export default  Login ;
