import React from 'react'
import { shallow } from 'enzyme';
import sinon from 'sinon';

import Wall from '../component/Wall'

describe('Wall page test suite', () => {

  it("Wall Exist",()=>{
    const wrapper = shallow(<Wall messages={[]}/>)
    expect(wrapper.exists("render"))
  })


})