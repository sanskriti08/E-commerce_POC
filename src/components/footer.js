import React from 'react'
import FacebookIcon from '@material-ui/icons/Facebook';
import InstagramIcon from '@material-ui/icons/Instagram';
export default function Footer(props) {
    const style = {
        color: 'white'
      };
      if(props.hidden)return null;
  if(props.hidden1) return null;
    return (
        <div className="footer">
            <p style={style}>copyright @2022</p>
            <div className="social" >
                <a href="https://www.facebook.com" target="_blank" rel="noreferrer" > <i className="fa"><FacebookIcon /></i></a>
                <a href="https://www.instagram.com" target="_blank" rel="noreferrer"><i className="fa" ><InstagramIcon/></i></a>
            </div>
        </div>
    )
}
