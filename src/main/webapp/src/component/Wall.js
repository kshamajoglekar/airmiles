import React, { Component } from 'react'
import '../css/App.css';

export default class Wall extends Component {

  constructor(props) {
    super(props)
  
    this.state = {
      user:'',
      city:[
        {
          name:"toronto",
          weather:"10Degrees Warmer"
        },
        {
          name:"vancouver",
          weather:"5Degrees Warm"
        },
        {
          name:"New York",
          weather:"15Degrees Pleasent"
        }
      ],
      masseges: [],
      newMessage: ''
    }
   
  }

  componentDidMount(){
    this.setState({masseges: this.props.messages})
  }

  updateState=(event) =>{
    if (this.state[event.target.name] !== undefined) {
      this.setState( {[event.target.name]: event.target.value})
    }

  }

  render () {
    return (
      <div className="Login">

        <h3>Wall</h3>

        Post message: 
          <input
            type="text" name="newMessage" 
            value={this.state.newMessage} onChange={this.updateState} />

          <button className="add" onClick={()=>this.props.handlePostMessage(this.state.newMessage)}>Post</button>

        <br /><br />
        <h5> Here are all your messeges: </h5>
        <h6>
          <table >
          {
            this.props.messages.map((message) => {
              return (
                <tr>
                <td id={message}>
                  {message}
                </td>
                </tr>
              )
            })
          }         
        
          </table>
        </h6>        
      </div>
    )
  }

}


