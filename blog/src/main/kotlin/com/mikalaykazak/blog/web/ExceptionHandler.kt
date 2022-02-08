package com.mikalaykazak.blog.web

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

	override fun handleMethodArgumentNotValid(
		ex: MethodArgumentNotValidException,
		headers: HttpHeaders,
		status: HttpStatus,
		request: WebRequest,
	): ResponseEntity<Any> {
		val errors = ex.bindingResult.fieldErrors
			.map { "${it.field} ${it.defaultMessage}" }
			.toList()
		return handleExceptionInternal(ex, errors, headers, status, request)
	}

	//TODO change message
	@ExceptionHandler(value = [EmptyResultDataAccessException::class])
	fun handleEmptyResultDataAccessException(
		ex: EmptyResultDataAccessException,
		request: WebRequest,
	): ResponseEntity<Any> {
		return handleExceptionInternal(ex,
			ex.message,
			HttpHeaders(),
			HttpStatus.BAD_REQUEST,
			request)
	}

	//TODO change message
	@ExceptionHandler(value = [DataIntegrityViolationException::class])
	fun handleDataIntegrityViolationException(
		ex: DataIntegrityViolationException,
		request: WebRequest,
	): ResponseEntity<Any> {
		return handleExceptionInternal(ex,
			null,
			HttpHeaders(),
			HttpStatus.BAD_REQUEST,
			request)
	}

	@ExceptionHandler(value = [EntityNotFoundException::class])
	fun handleEntityNotFoundException(
		ex: EntityNotFoundException,
		request: WebRequest,
	): ResponseEntity<Any> {
		return handleExceptionInternal(ex,
			ex.message,
			HttpHeaders(),
			HttpStatus.BAD_REQUEST,
			request)
	}

	//TODO change message
	@ExceptionHandler(value = [IllegalArgumentException::class])
	fun handleIllegalArgumentException(
		ex: IllegalArgumentException,
		request: WebRequest,
	): ResponseEntity<Any> {
		return handleExceptionInternal(ex,
			ex.message,
			HttpHeaders(),
			HttpStatus.BAD_REQUEST,
			request)
	}
}