import React from 'react'
import { shallow } from 'enzyme';

import Login from '../component/Login'


describe("Login Test Suite", () => { 

  it("Login Exist",()=>{
    const wrapper = shallow(<Login />)
    expect(wrapper.exists("render"))
  })

  it("Test if Login component exist", ()=> {
    const wrapper = shallow(<Login />)
    const state=wrapper.state()

    expect(state.city).toBe('')

  })

})