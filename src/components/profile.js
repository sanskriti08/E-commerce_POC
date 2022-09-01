import React from 'react';
import { useState } from "react";
import { useHistory } from "react-router";
import useFetch from './useFetch';
import '../profile.css'
// export default function Profile() {  
    const Profile= () => {
        const [address,setAddress]=useState('');
        const [phone,setPhone]=useState('');
        const [email,setEmail]=useState('');
        const [username,setUname]=useState(localStorage.getItem("username"));
        const [pass,setPass]=useState(localStorage.getItem("password"));
        const history = useHistory();
        const usef=new useFetch();
        const handleUpdate = (e) => {
            // e.preventDefault();
            const data= { address, email, phone,pass,username };
            usef.handleup(data);
    }
    
    return ( 
        // <h1>this is profile page</h1>
        <div className="Profile">
            <form onSubmit={handleUpdate}>
                <input type="text" value={email} placeholder="Updated Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
              title="Must have @ ,. and something after ." onChange={(e)=>setEmail(e.target.value)} />
            <input type="text" value={address} placeholder="Updated Address" pattern=".{6,}"  onChange={(e)=>setAddress(e.target.value)} />
                <input type="text" value={phone} placeholder="Updated Phone no" pattern="[789][0-9]{9}"
              title="Must be of 10 digits and start from 6,7,8 or 9" onChange={(e)=>setPhone(e.target.value)}  />
                
                <button className='b6'>Update Changes</button>

            </form>
        </div>
    ); 
    }
    export default Profile
