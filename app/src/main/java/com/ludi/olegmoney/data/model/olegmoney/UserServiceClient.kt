// Code generated by Wire protocol buffer compiler, do not edit.
// Source: olegmoney.UserService in user_service.proto
package olegmoney

import com.squareup.wire.GrpcCall
import com.squareup.wire.Service

public interface UserServiceClient : Service {
  public fun SignUp(): GrpcCall<UserRequest, UserResponse>

  public fun SignIn(): GrpcCall<UserRequest, UserResponseLogin>
}
