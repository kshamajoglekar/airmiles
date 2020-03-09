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
      masseges: ['jio','bgjhg']
    }
   
  }

  componentDidMount(){
    this.setState({masseges: this.props.messages})
  }
  handleAddPerson = () =>{
    const {firstName, lastName } = this.state
    this.props.addPerson(firstName, lastName)
    this.setState( {firstName, lastName} )
  }

  handleChange = (event) => {
    if (this.state[event.target.name] !== undefined) {
      this.setState( {[event.target.name]: event.target.value})
    }
  }

  render () {
    return (
      <div className="Login">
        <h3>Wall</h3>
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


