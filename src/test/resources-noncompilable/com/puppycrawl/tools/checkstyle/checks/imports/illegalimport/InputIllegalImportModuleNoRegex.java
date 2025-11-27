/*
IllegalImport
illegalPkgs = (default)sun
illegalClasses = (default)
illegalModules = java.base,java.logging
regexp = (default)false


*/

// non-compiled with javac: Compilable with Java25
package com.puppycrawl.tools.checkstyle.checks.imports.illegalimport;

import module java.base; // violation 'Illegal import - java.base'
import module java.xml;
import module java.sql;
import module java.logging; // violation 'Illegal import - java.logging'

class InputIllegalImportModuleNoRegex {}
