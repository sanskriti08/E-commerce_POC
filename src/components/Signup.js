import {useState} from "react";
import {useHistory} from "react-router-dom";
import useFetch from "./useFetch";
import '../login.css'
const Signup = () => {
    const [fullName,setName]=useState('');
    const [userName,setUname]=useState('');
    const [email,setEmail]=useState('');
    const [phone,setPhone]=useState('');
    const [password,setPass]=useState('');
    const [address,setAdd]=useState('');
    const usef=new useFetch();
    const history=useHistory();
    const handleSignUp=(e)=>{
        e.preventDefault();
        const users={fullName,userName,email,phone,password,address};
        usef.handleadd(users);
            
            history.push("/login");
            
    
    
    }
    return ( 
        <div className="contains">
        <div class="signup">
            
        <button class="button a1"
            
            onClick={(e) => {
            e.preventDefault();
            history.push("/signup");
        }}
        > Signup</button>
        <button class="button b1"
            
            onClick={(e) => {
            e.preventDefault();
            history.push("/login");
        }}
    >Login</button>
    
          <h2>Signup form</h2>
          <form onSubmit={handleSignUp}>
              <input class= "i"
              type="text"
              required
              placeholder="Enter full name"
              value={fullName}
              onChange={(e)=>setName(e.target.value)}
              />
              <input class= "i"
              type="text"
              required
              placeholder="Enter Username"
              value={userName}
              onChange={(e)=>setUname(e.target.value)}
              />
              <input class= "i"
              type="text"
              required
              pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
              title="Must have @,. and something after ."
              placeholder="Enter Email"
              value={email}
              onChange={(e)=>setEmail(e.target.value)}
              />
              <input class= "i"
              type="text"
              required
              pattern="[789][0-9]{9}"
              title="Must be of 10 digits and start from 7,8 or 9"
              placeholder="Enter Phone Number"
              value={phone}
              onChange={(e)=>setPhone(e.target.value)}
              />
              <input class= "i"
              type="text"
              required
              pattern=".{8,}"
              title="Length can't be less than 8"
              placeholder="Enter Address"
              value={address}
              onChange={(e)=>setAdd(e.target.value)}
              />
              <input class= "i"
              type="password"
              required
              pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
              title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters"
              placeholder="Enter Password"
              value={password}
              onChange={(e)=>setPass(e.target.value)}
              />
              <button class="b3">Signup</button>
              
          </form>
      </div>  
      </div>
     );
}
 
export default  Signup ;
