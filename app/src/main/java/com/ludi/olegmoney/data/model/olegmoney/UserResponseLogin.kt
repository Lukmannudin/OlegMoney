// Code generated by Wire protocol buffer compiler, do not edit.
// Source: olegmoney.UserResponseLogin in user.proto
package olegmoney

import android.os.Parcelable
import com.squareup.wire.AndroidMessage
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import com.squareup.wire.`internal`.JvmField
import com.squareup.wire.`internal`.sanitize
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import okio.ByteString

public class UserResponseLogin(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    schemaIndex = 0,
  )
  @JvmField
  public val token: String = "",
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<UserResponseLogin, UserResponseLogin.Builder>(ADAPTER, unknownFields) {
  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.token = token
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is UserResponseLogin) return false
    if (unknownFields != other.unknownFields) return false
    if (token != other.token) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + token.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """token=${sanitize(token)}"""
    return result.joinToString(prefix = "UserResponseLogin{", separator = ", ", postfix = "}")
  }

  public fun copy(token: String = this.token, unknownFields: ByteString = this.unknownFields):
      UserResponseLogin = UserResponseLogin(token, unknownFields)

  public class Builder : Message.Builder<UserResponseLogin, Builder>() {
    @JvmField
    public var token: String = ""

    public fun token(token: String): Builder {
      this.token = token
      return this
    }

    override fun build(): UserResponseLogin = UserResponseLogin(
      token = token,
      unknownFields = buildUnknownFields()
    )
  }

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<UserResponseLogin> = object : ProtoAdapter<UserResponseLogin>(
      FieldEncoding.LENGTH_DELIMITED, 
      UserResponseLogin::class, 
      "type.googleapis.com/olegmoney.UserResponseLogin", 
      PROTO_3, 
      null, 
      "user.proto"
    ) {
      override fun encodedSize(`value`: UserResponseLogin): Int {
        var size = value.unknownFields.size
        if (value.token != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.token)
        return size
      }

      override fun encode(writer: ProtoWriter, `value`: UserResponseLogin) {
        if (value.token != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.token)
        writer.writeBytes(value.unknownFields)
      }

      override fun encode(writer: ReverseProtoWriter, `value`: UserResponseLogin) {
        writer.writeBytes(value.unknownFields)
        if (value.token != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.token)
      }

      override fun decode(reader: ProtoReader): UserResponseLogin {
        var token: String = ""
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> token = ProtoAdapter.STRING.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return UserResponseLogin(
          token = token,
          unknownFields = unknownFields
        )
      }

      override fun redact(`value`: UserResponseLogin): UserResponseLogin = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<UserResponseLogin> = AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
